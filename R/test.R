library(rJava)
library(arules)
library(stringr)

data_raw <- read.csv("C:/code/python/machine_learning/assoc_rules/train/iris0.csv")

as.qcba.rules <- function (rules) {
  
  lhsMatrix <- as(rules@lhs, "matrix")
  rhsMatrix <- as(rules@rhs, "matrix")
  
  
  ruleCount <- nrow(lhsMatrix)
  
  ruleStrings <- c()
  
  for (i in 1:ruleCount) {
    currentLHSRow <- lhsMatrix[i,]
    currentRHSRow <- rhsMatrix[i,]
    
    
    # subset only true values
    # we'll get only the items that the rule contains
    # then we'll take the names of those items
    lhsSubset <- names(currentLHSRow[currentLHSRow])
    rhsSubset <- names(currentRHSRow[currentRHSRow])
    
    lhsString <- paste(lhsSubset, collapse = ",")
    rhsString <- paste(rhsSubset, collapse = ",")
    
    # add curly braces to antecedent and consequent
    lhsString <- paste("{", lhsString, "}", sep = "")
    rhsString <- paste("{", rhsString, "}", sep = "")
    
    ruleStr <- paste(lhsString, "=>", rhsString)
    
    ruleStrings <- c(ruleStrings, ruleStr)
  }
  
  rulesQuality <- rules@quality
  
  newRules <- data.frame(rules = ruleStrings,
                         support = rulesQuality$support,
                         confidence = rulesQuality$confidence,
                         stringsAsFactors = FALSE)
  newRules
}

.jinit()
.jaddClassPath("dist/JavaIDS.jar")


freqItemObj <- .jnew(class = "fpgrowth/FrequentItem", "sepallength", "0.8_to_inf")
freqItemObj$getLabel()

mined_rules <- arules::apriori(data_raw)
rules_df <- as.qcba.rules(mined_rules)

colnames(rules_df)

rInterface = .jnew(class = "rinterface/RInterface")

ruleStringMatrix <- .jarray(as.matrix(rules_df), dispatch = T)
