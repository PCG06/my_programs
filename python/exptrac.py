"""
    Python Assignment:
    Creating an expense tracker using CustomTkinter (UI) and SQLite (DB)
"""

import sqlite3 as sql
import customtkinter as ctk
from tkinter import messagebox, ttk
from datetime import date

ctk.set_appearance_mode("dark")
ctk.set_default_color_theme("blue")

DB = "exptrac.db"

def init_db():
    conn = sql.connect(DB)
    conn.execute("""
        CREATE TABLE IF NOT EXISTS exptrac (
            id       INTEGER PRIMARY KEY AUTOINCREMENT,
            type     TEXT,
            category TEXT,
            amount   REAL,
            note     TEXT,
            date     TEXT
        )
    """)
    conn.commit()
    conn.close()

INC_CATEGORIES = ["Salary", "Investment", "Gift", "Other"]
EXP_CATEGORIES = ["Food", "Transport", "Rent", "Shopping", "Health", "Entertainment", "Other"]
ALL_CATEGORIES = ["All"] + INC_CATEGORIES + EXP_CATEGORIES

class App(ctk.CTk):
    def __init__(self):
        super().__init__()
        self.title("Expense Tracker")
        self.geometry("700x650")
        init_db()
        self.ui_build_layout()

    def exp_inc_type_changer(self, value):
        cats = INC_CATEGORIES if value == "Income" else EXP_CATEGORIES
        self.cat_menu.configure(values=cats)
        self.cat_var.set(cats[0])

    def ui_build_layout(self):
        # -- Input Form --
        wrapper = ctk.CTkFrame(self, fg_color="transparent")
        wrapper.pack(fill="x", pady=15)
        wrapper.columnconfigure(0, weight=1)
        wrapper.columnconfigure(2, weight=1)

        form = ctk.CTkFrame(wrapper)
        form.grid(row=0, column=1)

        ctk.CTkLabel(form, text="Expense Tracker", font=ctk.CTkFont(size=20, weight="bold")).grid(row=0, column=0, columnspan=4, pady=(10, 15))

        # Insert fields
        # Type
        self.type_var = ctk.StringVar(value="Expense")
        ctk.CTkLabel(form, text="Type:").grid(row=1, column=0, padx=10, pady=5, sticky="e")
        ctk.CTkOptionMenu(form, variable=self.type_var, values=["Expense", "Income"], width=130, command=self.exp_inc_type_changer).grid(row=1, column=1, padx=5, pady=5, sticky="w")

        # Category
        self.cat_var = ctk.StringVar(value=EXP_CATEGORIES[0])
        ctk.CTkLabel(form, text="Category:").grid(row=1, column=2, padx=10, sticky="e")
        self.cat_menu = ctk.CTkOptionMenu(form, variable=self.cat_var, values=EXP_CATEGORIES, width=130)
        self.cat_menu.grid(row=1, column=3, padx=5, pady=5, sticky="w")

        # Amount
        self.amt = ctk.CTkEntry(form, placeholder_text="Amount", width=130)
        ctk.CTkLabel(form, text="Amount:").grid(row=2, column=0, padx=10, pady=5, sticky="e")
        self.amt.grid(row=2, column=1, padx=5, pady=5, sticky="w")

        # Note
        self.note = ctk.CTkEntry(form, placeholder_text="Note (optional)", width=130)
        ctk.CTkLabel(form, text="Note:").grid(row=2, column=2, padx=10, sticky="e")
        self.note.grid(row=2, column=3, padx=5, pady=5, sticky="w")

        # Date
        self.date_entry = ctk.CTkEntry(form, placeholder_text="YYYY-MM-DD", width=130)
        self.date_entry.insert(0, date.today().strftime("%d-%m-%Y"))
        ctk.CTkLabel(form, text="Date:").grid(row=3, column=0, padx=10, pady=5, sticky="e")
        self.date_entry.grid(row=3, column=1, padx=5, pady=5, sticky="w")

        # Add button
        ctk.CTkButton(form, text="Add", width=130, fg_color="#2ecc71", hover_color="#27ae60", command=self.insert_record).grid(row=3, column=3, padx=5, pady=5, sticky="w")

        # -- Summary Bar --
        self.summary = ctk.CTkLabel(self, text="", font=ctk.CTkFont(size=13))
        self.summary.pack(pady=5)

        # -- Filter / Sort Bar --
        bar = ctk.CTkFrame(self)
        bar.pack(padx=20, pady=(0, 5), fill="x")

        ctk.CTkLabel(bar, text="Filter:").pack(side="left", padx=(10, 4), pady=8)

        self.filter_type = ctk.CTkOptionMenu(bar, values=["All", "Income", "Expense"], width=110, command=lambda _: self.load_records())
        self.filter_type.pack(side="left", padx=4)

        self.filter_cat = ctk.CTkOptionMenu(bar, values=ALL_CATEGORIES, width=130, command=lambda _: self.load_records())
        self.filter_cat.pack(side="left", padx=4)

        ctk.CTkLabel(bar, text="Sort:").pack(side="left", padx=(12, 4))

        self.sort_var = ctk.CTkOptionMenu(bar, command=lambda _: self.load_records(), values=["Date: Latest", "Date: Oldest", "Amount: High", "Amount: Low"], width=150)
        self.sort_var.pack(side="left", padx=4)

        ctk.CTkButton(bar, text="Reset", width=70, command=self.reset_filters).pack(side="right", padx=10)

        # -- Table --
        style = ttk.Style()
        style.theme_use("clam")
        style.configure("Treeview", background="#2d2d2d", foreground="white", rowheight=18, fieldbackground="#2d2d2d", font=("Arial", 11))
        style.configure("Treeview.Heading", background="#1a1a1a", foreground="white", font=("Arial", 11, "bold"))
        style.map("Treeview", background=[("selected", "#3498db")])

        cols = ("ID", "Type", "Category", "Amount", "Note", "Date")
        self.tree = ttk.Treeview(self, columns=cols, show="headings", height=14)
        widths = (40, 80, 110, 90, 200, 100)
        for col, w in zip(cols, widths):
            self.tree.heading(col, text=col)
            self.tree.column(col, width=w, anchor="center")
        self.tree.pack(padx=20, pady=5, fill="both", expand=True)

        # -- Delete Button --
        ctk.CTkButton(self, text="Delete Selected", fg_color="#e74c3c", hover_color="#c0392b", command=self.delete_record).pack(pady=10)

        self.load_records()

    def reset_filters(self):
        self.filter_type.set("All")
        self.filter_cat.set("All")
        self.sort_var.set("Date: Latest")
        self.load_records()

    def insert_record(self):
        try:
            amt = float(self.amt.get())
            assert amt > 0
        except:
            messagebox.showerror("Error", "Enter valid amount.")
            return

        conn = sql.connect(DB)
        conn.execute("INSERT INTO exptrac (type, category, amount, note, date) VALUES (?,?,?,?,?)",
                    (self.type_var.get(), self.cat_var.get(), amt, self.note.get().strip(), self.date_entry.get().strip()))
        conn.commit()
        conn.close()

        self.amt.delete(0, "end")
        self.note.delete(0, "end")
        self.load_records()

    def delete_record(self):
        sel = self.tree.selection()
        if not sel:
            messagebox.showinfo("Select", "Select a row to delete.")
            return
        tid = self.tree.item(sel[0])["values"][0]
        if messagebox.askyesno("Delete", f"Delete entry #{tid}?"):
            conn = sql.connect(DB)
            conn.execute("DELETE FROM exptrac WHERE id=?", (tid,))
            conn.commit()
            conn.close()
            self.load_records()

    def load_records(self):
        for row in self.tree.get_children():
            self.tree.delete(row)

        # Build query with filters and sort
        query = "SELECT id, type, category, amount, note, date FROM exptrac WHERE 1=1"
        params = []

        ft = self.filter_type.get()
        if ft != "All":
            query += " AND type=?"
            params.append(ft)

        fc = self.filter_cat.get()
        if fc != "All":
            query += " AND category=?"
            params.append(fc)

        sort = self.sort_var.get()
        if sort == "Date: Latest":   query += " ORDER BY date DESC"
        elif sort == "Date: Oldest": query += " ORDER BY date ASC"
        elif sort == "Amount: High": query += " ORDER BY amount DESC"
        elif sort == "Amount: Low":  query += " ORDER BY amount ASC"

        conn = sql.connect(DB)
        rows = conn.execute(query, params).fetchall()
        # Always compute totals from full table
        totals = conn.execute("SELECT type, amount FROM exptrac").fetchall()
        conn.close()

        for row in rows:
            tag = "inc" if row[1] == "Income" else "exp"
            self.tree.insert("", "end", values=(row[0], row[1], row[2], f"Rs.{row[3]:,.2f}", row[4], row[5]), tags=(tag,))

        self.tree.tag_configure("inc", foreground="#2ecc71")
        self.tree.tag_configure("exp", foreground="#e74c3c")

        income  = sum(r[1] for r in totals if r[0] == "Income")
        expense = sum(r[1] for r in totals if r[0] == "Expense")
        bal_color = "#2ecc71" if income >= expense else "#e74c3c"
        self.summary.configure(text=f"Income: Rs.{income:,.2f}   |   Expense: Rs.{expense:,.2f}   |   Balance: Rs.{income - expense:,.2f}", text_color=bal_color)

if __name__ == "__main__":
    App().mainloop()
