Copyright 2015 Joshua Driesman

## About
This software is a demonstration of clustering image data using Kruskal's algorithm running on an implementation of
UnionFind. It was originally developed as a project for CS4800 Algorithms and Data Structures taught by Professor
Jacek Ossowski at Northeastern University.

## Compile/Install

#### Requirements

- Java 1.8 or better
- Maven

#### Directions
To build source:

1. ```$ mvn install```
2. All build files will be placed under ```/target```

Note: The JAR is not executable. To create an executable JAR, see the directions below.

To build executable JAR:

1. ```$ mvn assembly:assembly```
2. The JAR will be found under:
```target/ClusteringUsingKruskals-1.0-SNAPSHOT-jar-with-dependencies.jar```

## Run

First, make sure to have built the executable JAR.

To run, use the following command:

```java -jar target/ClusteringUsingKruskals-1.0-SNAPSHOT-jar-with-dependencies.jar {image data file location} {number of clusters} {cluster results output} {purity results output} {verbose clusters?}```

#### Inputs
 - {image data file location} - REQUIRED: the location of the file containing the image segment data for clustering, an example file is located under src/main/resources/segment-full.arff
 - {number of clusters} - OPTIONAL: the number of clusters to form with Kruskal's algorithm. DEFAULT: 1
 - {cluster results output} - OPTIONAL: where to store the resulting clusters. Will product a verbose output file with every cluster and the ImageSegment data each cluster contains. DEFAULT: ./clusters.txt
 - {purity results output} - OPTIONAL: where to store the purity report. The purity report is a CSV file, one column is the number of clusters, the other column is the "purity" of those clusters. DEFAULT: ./purity.csv
 - {verbose clusters?} - OPTIONAL: whether or not to write out verbose clustering results. (y/n) DEFAULT: n