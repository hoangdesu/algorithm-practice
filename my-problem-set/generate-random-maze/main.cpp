#include <iostream>
#include <vector>
#include <string>

#include "maze.h"

using namespace std;

int main()
{
    // cout << "Enter maze's dimensions (e.g. 9 11, default 7x7): ";

    // string input;
    // getline(cin, input);

    vector<vector<char>> maze;
    // if (input.empty())
    // {
    //     maze = maze::build();
    // }

    int width = 31;
    int height = 11;

    maze = mz::build(width, height);
    cout << "\nBuild: " << endl;
    mz::print(maze);

    // maze::recursive_division(maze);

    std::random_device rd;
    std::mt19937 gen(rd());
    mz::recursive_division(maze, 1, 1, width - 2, height - 2, gen); // exclude borders

    // TODO: add entrance

    cout << "\nRecursive division: " << endl;
    mz::print(maze);

    cout << "\nAdd entrance: " << endl;
    mz::addEntrance(maze, gen);
    mz::print(maze);

    return 0;
}
