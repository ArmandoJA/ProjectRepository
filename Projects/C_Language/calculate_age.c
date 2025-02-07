#include<stdio.h>
#include<stdlib.h>

void verifyDate(int month, int day, int year);
int daysPerMonth(int month, int year);

int main() {

        int c_month, c_day, c_year;
        int b_month, b_day, b_year;
        int a_month, a_day, a_year;

        printf("Enter Current Date (MM DD YYYY):\n");
        scanf("%d %d %d", &c_month, &c_day, &c_year);
        verifyDate(c_month, c_day, c_year);
        printf("Enter Your Birth Date (MM DD YYYY):\n");
        scanf("%d %d %d",&b_month, &b_day, &b_year);
        verifyDate(b_month, b_day, b_year);

        if (c_day < b_day) {
            if (daysPerMonth(c_month, c_year) == 31 || c_month == 9) {
                a_day = 30 - (b_day - c_day);
            }
            if (daysPerMonth(c_month, c_year) == 30 && c_month != 9 || c_month == 2) {
                a_day = 31 - (b_day - c_day);
            }

        }
        else {
            a_day = c_day - b_day;
        }

        if (c_month > b_month || (c_month == b_month && c_day >= b_day)) {
            a_year = c_year - b_year;
        }
        else {
            a_year = c_year - b_year - 1;
        }

        if (c_month < b_month || (c_month == b_month && c_day < b_day)) {
            a_month = (c_month + 12) - b_month;
        }
        else {
            a_month = c_month - b_month;
        }

        if (c_day < b_day) {
            a_month --;
        }

        printf("Your age is %d years %d months and %d days!\n", a_year, a_month, a_day);

        return 0;
}


void verifyDate(int month, int day, int year) {
        if(month < 1 || month > 12) {
                printf("Invalid month, try again\n");
                exit(0);
        }
        int daysInMonth = daysPerMonth(month, year);
        if (day < 1 || day > daysInMonth) {
                printf("Invalid day, try again\n");
                exit(0);
        }
}

int daysPerMonth(int month, int year) {
        switch(month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        return 31;
                        break;
                case 4: case 6: case 9: case 11:
                        return 30;
                        break;
                case 2:
                        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                                return 29;
                        }
                        else {
                                return 28;
                        }
                    break;
                default:
                    return -1;
    }
}