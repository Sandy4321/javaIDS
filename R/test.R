library(rJava)

.jinit()
.jaddClassPath("dist/JavaIDS.jar")


.jclassPath("dist/JavaIDS.jar")

freqItemObj <- .jnew(class = "fpgrowth/FrequentItem", "sepallength", "0.8_to_inf")
freqItemObj$getLabel()
