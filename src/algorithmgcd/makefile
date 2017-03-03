JCC = javac

JFLAGS = -g

JRUN = java

PICO = pico

default: Project1x.class

#-------------------------------------
Project1x.class: Project1x.java
	$(JCC) $(JFLAGS) Project1x.java
#-------------------------------------
clean:
	$(RM) *.class

run:
	$(JRUN) Project1x testfile.txt

