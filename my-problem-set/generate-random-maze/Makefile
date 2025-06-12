.default: all

all: clean main

clean:
	rm -f main *.o

main: main.o
	g++ -Wall -Werror -std=c++17 -O -g -o main ./*.cpp
# g++ -std=c++17 -O -g -o main ./*.cpp
	./main

%.o: %.cpp
	g++ -Wall -Werror -std=c++17 -g -O -c $^
# g++ -std=c++17 -g -O -c $^