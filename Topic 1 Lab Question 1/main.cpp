//Erick Grant, CST-210TT1100, Demland
#include <iostream>
using namespace std;
int main() {
    int m;
    int n;
    cout << "Enter two positive integers: "; // Ask user for two nums
    cin >> m; // Get numerator
    cout << " "; //Add a space
    cin >> n; // Get denominator
    //Ensure all nums are > 0
    bool good = true;
    if ((m <= 0)||(n <= 0)) { //Error handle for less or equal to zero
        cout << "Negative/zero number detected, please retry!";
        good = false;
    }
    if (good) {
        int q = m / n; //Divide m by n, resulting in a whole number
        int r = m % n; //Remainder of division of m and n

        string output = to_string(m) + " = " + to_string(n) + " * " + to_string(q) + " + " +
                        to_string(r); // Generate string output

        cout << output;

    }
    cout << "\n \n";
        main(); //RECURSION
    return 0;
}


