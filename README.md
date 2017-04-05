# Nailbucket

#### Introduction

A java project that allows anyone to create their own algorithms to travel aroud an area and collect the nails in the most efficient (or least efficient) manner.

#### Getting Started

First clone the project using `git clone https://github.com/tejedu/nailbucket.git`.

The project comes with two route generators ready to go, Closest and Random. To build the project and see these in action, run `javac Nailbucket.java` and then `java Nailbucket`. You should get a window that looks something like this:

![Example Image](http://imgur.com/QrSw3bl)

#### Making Your Own Algorithm

To make your own algorithm you need to do two things. First, create a new file in the pathing/routegen. There is a file there, `SkeletonRouteGenerator.java` that you can copy and rename. The last thing you need to do is register the generator in the `Nailbucket.java` file. Instructions on how to do so are inside.
