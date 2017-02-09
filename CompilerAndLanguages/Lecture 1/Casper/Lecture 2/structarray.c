#include "stdio.h"
#include "string.h"

struct StudentInfo {
    char name[25];
    char gradeLevel[20];
    int age;
    float GPA;
};

void makeDBStruct(struct StudentInfo db[], struct StudentInfo student_casper, char studentname[], char gradelevel[], int age, float gpa);
void makeDBArray(char nameArray[], char gradeArray[], int ageArray[], float GPAArray[], char name[], char grade[], int age, float gpa);

int main(){
    /* This is the struct part */
    struct StudentInfo student_casper;
    struct StudentInfo student_db[10];
    
    makeDBStruct(student_db, student_casper, "Casper", "4. Semester", 20, 12.3f);
    
    for(int i = 0; i < 9; i++){
        printf("Name: %s  | Grade: %s   | Age: %i   |  GPA: %f \n", student_db[i].name, student_db[i].gradeLevel, student_db[i].age, student_db[i].GPA);
    }
    
    printf("---------------------------------------\n");
    
    /* This is the none struct part */
    char nameArray[10], gradeArray[10];
    int ageArray[4];
    float GPAArray[2];
    
    makeDBArray(nameArray, gradeArray, ageArray, GPAArray, "CasperT", "Semester 4", 20, 0.0f);
    
    for(int i = 0; i < 9; i++){
        printf("Name: %c  | Grade: %c   | Age: %i   |  GPA: %f \n", nameArray[i], gradeArray[i], ageArray[i], GPAArray[i]);
    }
    
    
    return 1;
}

void makeDBArray(char nameArray[], char gradeArray[], int ageArray[], float GPAArray[], char name[], char grade[], int age, float gpa){
    for(int i = 0; i < 9; i++){
        strcpy(&nameArray[i], name);
        strcpy(&gradeArray[i], grade);
        ageArray[i] = age;
        GPAArray[i] = gpa;
    }
}

void makeDBStruct(struct StudentInfo db[], struct StudentInfo student_casper, char studentname[], char gradelevel[], int age, float gpa){
    for(int i = 0; i < 9; i++){
        strcpy(student_casper.name, studentname);
        strcpy(student_casper.gradeLevel, gradelevel);
        student_casper.age = age;
        student_casper.GPA = gpa;
        
        db[i] = student_casper;
    }
    
}
