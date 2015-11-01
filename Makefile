run: Simulator.class
	java Simulator

Human.class: Human.java
	javac Human.java

Simulator.class: Simulator.java Human.java
	javac Simulator.java

clean: 
	rm -f *.class
