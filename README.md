# Ellipse Recognition through Genetic Algorithms in Clojure

### NOTE: This algorithm doesn't work yet and converges prematurely, it needs to be fixed
Genetic algorithm that finds the best ellipse that fits in the image.

Ideally, the image should be in black and white or optimized in grayscale, although, theorically any image would suffice.

An example of an image could be this one, used in the tests:

![](https://raw.githubusercontent.com/NickSeagull/ellipse-recognition/master/resources/coins.jpg)

For a better understanding of how the code is organized, it is recommended to read the tests under the ```spec/ellipse_recognition``` folder.

Also, at the time I'm writing this, I do not know a **good** way to test undeterministic algorithms such as genetic algorithms or particle swarm algorithms. So don't get scared if what you see in the test is only length testing.

## Running the algorithm

To run the algorithm it will suffice to clone this repository and run:
```
lein run
```
To run the algorithm,
or
```
lein spec
```
To run the tests.
