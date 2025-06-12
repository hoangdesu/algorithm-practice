#pragma once

#include <iostream>
#include <vector>
#include <random>

using namespace std;

namespace mz
{
    vector<vector<char>> build(int width, int height)
    {
        vector<vector<char>> maze;

        for (int i = 0; i < height; i++)
        {
            char c;
            vector<char> row;
            for (int j = 0; j < width; j++)
            {
                // top and bottom
                if (i == 0 || i == height - 1)
                {
                    c = 'x';
                }
                // other rows in between
                else
                {
                    // left and right borders
                    if (j == 0 || j == width - 1)
                    {
                        c = 'x';
                    }
                    // cells in between
                    else
                    {
                        c = ' ';
                    }
                }
                row.push_back(c);
            }
            maze.push_back(row);
            row.clear();
        }

        return maze;
    }

    void print(vector<vector<char>> &maze)
    {
        for (vector<char> row : maze)
        {
            for (char c : row)
            {
                cout << c << " ";
            }
            cout << endl;
        }
        cout << endl;
    }

    void recursive_division1(vector<vector<char>> &maze)
    {
        // Random starting direction
        // 0: horiontal, 1: vertical

        enum Direction
        {
            HORIZONTAL, // 0
            VERTICAL    // 1
        };

        std::random_device rd;                                                                          // Source of randomness
        std::mt19937 gen(rd());                                                                         // Mersenne Twister engine seeded with random device
        std::uniform_int_distribution<> get_random_direction(0, static_cast<int>(Direction::VERTICAL)); // Distribution for integers, from 0 to last element

        int direction = get_random_direction(gen);
        cout << "Starting Direction: " << direction;

        int maze_size;
        if (direction == 0)
        {
            cout << " = horizontal" << endl;
            maze_size = maze.size() - 1; // exclude border
        }
        else
        {
            cout << " = vertical" << endl;
            maze_size = maze[0].size() - 1; // exclude border
        }
        cout << "Maze size: " << maze_size << endl;

        std::uniform_int_distribution<> get_random_index(1, maze_size - 1);
        int random_index = get_random_index(gen);

        // starting random index must be an even number
        while (random_index % 2 != 0)
        {
            random_index = get_random_index(gen);
        }

        cout << "Random index = " << random_index << endl;

        // place dividing wall horizontal
        if (direction == 0)
        {
            for (int i = 1; i < maze[0].size() - 1; i++)
            {
                maze[random_index][i] = 'x';
            }
        }
        // place dividing wall vertical
        else
        {
            for (int j = 1; j < maze.size() - 1; j++)
            {
                maze[j][random_index] = 'x';
            }
        }
    }

    void recursive_division(vector<vector<char>> &maze, int x, int y, int width, int height, std::mt19937 &gen)
    {
        if (width <= 2 || height <= 2)
            return;

        enum Direction
        {
            HORIZONTAL,
            VERTICAL
        };

        std::uniform_int_distribution<> get_random_direction(0, 1);
        int direction = (width < height) ? HORIZONTAL : (height < width) ? VERTICAL
                                                                         : get_random_direction(gen);

        if (direction == HORIZONTAL)
        {
            std::uniform_int_distribution<> wall_dist(y + 1, y + height - 2);
            int wall_y = wall_dist(gen);
            if (wall_y % 2 != 0)
                wall_y++; // Make even (wall row)

            std::uniform_int_distribution<> hole_dist(x + 1, x + width - 2);
            int hole_x = hole_dist(gen);
            if (hole_x % 2 == 0)
                hole_x++; // Make odd (hole in wall)

            for (int i = x; i < x + width; i++)
            {
                if (i == hole_x)
                    continue;
                maze[wall_y][i] = 'x';
            }

            // Recurse above and below the wall
            recursive_division(maze, x, y, width, wall_y - y, gen);
            recursive_division(maze, x, wall_y + 1, width, y + height - wall_y - 1, gen);
        }
        else
        {
            std::uniform_int_distribution<> wall_dist(x + 1, x + width - 2);
            int wall_x = wall_dist(gen);
            if (wall_x % 2 != 0)
                wall_x++; // Make even (wall column)

            std::uniform_int_distribution<> hole_dist(y + 1, y + height - 2);
            int hole_y = hole_dist(gen);
            if (hole_y % 2 == 0)
                hole_y++; // Make odd (hole in wall)

            for (int j = y; j < y + height; j++)
            {
                if (j == hole_y)
                    continue;
                maze[j][wall_x] = 'x';
            }

            // Recurse left and right of the wall
            recursive_division(maze, x, y, wall_x - x, height, gen);
            recursive_division(maze, wall_x + 1, y, x + width - wall_x - 1, height, gen);
        }
    }

    void addEntrance(vector<vector<char>> &maze, mt19937 &gen)
    {
        enum Direction
        {
            TOP,    // 0
            RIGHT,  // 1
            BOTTOM, // 2
            LEFT    // 3
        };

        cout << "static_cast<int>(LEFT): " << static_cast<int>(LEFT) << endl;

        std::uniform_int_distribution<> get_random_direction(0, static_cast<int>(LEFT));
        Direction random_direction = static_cast<Direction>(get_random_direction(gen));

        cout << "random_direction: " << random_direction << " = ";
        switch (random_direction) {
            case 0:
                cout << "TOP" << endl;
                break;
            case 1:
                cout << "RIGHT" << endl;
                break;
            case 2:
                cout << "BOTTOM" << endl;
                break;
            case 3:
                cout << "LEFT" << endl;
                break;
        }

        std::uniform_int_distribution<> maze_width_dist(0, maze[0].size() - 1);
        std::uniform_int_distribution<> maze_height_dist(0, maze.size() - 1);

        int i = 0, j = 0;
        if (random_direction == TOP)
        {
            i = 0; // always top row
            j = maze_width_dist(gen); // pick a random column
            while (maze[i + 1][j] != ' ')
            {
                j = maze_width_dist(gen); // pick another random column
                cout << "...stuck in: " << random_direction << endl;
            }
        }
        else if (random_direction == RIGHT)
        {
            i = maze_height_dist(gen); // pick a random row
            j = maze[0].size() - 1; // right border
            while (maze[i][j - 1] != ' ')
            {
                i = maze_height_dist(gen); // pick another row
                cout << "...stuck in: " << random_direction << endl;
            }
        }
        else if (random_direction == BOTTOM)
        {
            i = maze.size() - 1; // always at bottom row
            j = maze_width_dist(gen); // pick a random col
            while (maze[i - 1][j] != ' ')
            {
                j = maze_width_dist(gen);
                cout << "...stuck in: " << random_direction << endl;
            }
        }
        else if (random_direction == LEFT)
        {
            i = maze_height_dist(gen); // random row
            j = 0; // always left border
            cout << "old i = " << i << endl;
            while (maze[i][j + 1] != ' ')
            {
                i = maze_height_dist(gen);
                cout << "new i = " << i << endl;
                cout << "...stuck in: " << random_direction << endl;
            }
        }

        maze[i][j] = ' '; // replace with entrance
        cout << "Entrance added at: " << i << ":" << j << endl;
    }

}