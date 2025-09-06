# R script to create a choice menu with mean, median, mode of grouped data as options

lower <- as.numeric(unlist(strsplit(readline(prompt="Enter lower limits: "), ", ")))
upper <- as.numeric(unlist(strsplit(readline(prompt="Enter upper limits: "), ", ")))
freq <- as.numeric(unlist(strsplit(readline(prompt="Enter frequencies: "), ", ")))
ci <- paste(lower, "-", upper)

repeat {
    cat("---Menu---\n")
    cat("1: Mean\n")
    cat("2: Median\n")
    cat("3: Mode\n")
    cat("4: Exit\n")
    ch <- readline(prompt="\nEnter your choice: ")
    
    if (ch == 1) { # Mean
        mid <- (lower + upper) / 2
        fx <- freq * mid
        sum_fx <- sum(fx)
        sum_freq <- sum(freq)

        mean_value <- sum_fx / sum_freq

        data <- data.frame(
            "CI" = ci,
            "F" = freq,
            "Mid" = mid,
            "fx" = fx
        )
        cat("\n---Mean data---\n")
        print(data, right=FALSE, row.names=FALSE)
        cat("\nSum of fx:", sum_fx)
        cat("\nSum of freq:", sum_freq)
        cat("\n\nMean:", mean_value, "\n\n")
    } else if (ch == 2) { # Median
        cum_freq <- cumsum(freq)
        sum_cf <- sum(cum_freq)
        n <- sum(freq)
        for (i in 1:length(cum_freq)) {
            if (cum_freq[i] >= n / 2) {
                median_index <- i
                break
            }
        }
        l <- lower[median_index]
        h <- upper[median_index] - lower[median_index]
        f <- freq[median_index]
        if (median_index == 1) {
            F <- 0
        } else {
            F <- cum_freq[median_index - 1]
        }

        median_value <- l + ((n/2 - F) / f) * h

        data <- data.frame(
            "CI" = ci,
            "F" = freq,
            "CF" = cum_freq
        )
        cat("\n---Median data---\n")
        print(data, right=FALSE, row.names=FALSE)
        cat("\nSum of freq:", n)
        cat("\nMedian index:", median_index)
        cat("\nLower bound of median class:", l)
        cat("\nFrequency of median class:", f)
        cat("\nCumulative frequency of median class:", F)
        cat("\nHeight of median class:", h)
        cat("\n\nMedian:", median_value, "\n\n")
    } else if (ch == 3) { # Mode
        modal_index <- which.max(freq)
        l <- lower[modal_index]
        if (modal_index == 1) {
            f0 <- 0
        } else {
            f0 <- freq[modal_index - 1]
        }
        f1 <- freq[modal_index]
        if (modal_index == length(freq)) {
            f2 <- 0
        } else {
            f2 <- freq[modal_index + 1]
        }
        h <- upper[modal_index] - lower[modal_index]

        mode_value <- l + ((f1 - f0) / (2 * f1 - f0 - f2)) * h
        
        data <- data.frame(
            "CI" = ci,
            "F" = freq
        )
        cat("\n---Mode data---\n")
        print(data, right=FALSE, row.names=FALSE)
        cat("\nModal index:", modal_index)
        cat("\nLower bound of modal class:", l)
        cat("\nFrequency of class above modal class:", f0)
        cat("\nFrequency of modal class:", f1)
        cat("\nFrequency of class below modal class:", f2)
        cat("\nHeight of modal class:", h)
        cat("\n\nMode:", mode_value, "\n\n")
    } else if (ch == 4) { # Exit
        cat("Exiting...\n")
        break
    } else {
        cat("Invalid choice!\n")
    }
}
