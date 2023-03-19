#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

#define SIZE 10000 

void quicksort(int array[], int lo, int hi);
int partition(int array[], int lo, int hi);

int main(void) {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    
    int T, n, i;
    int tot_candy, candy;
    int marks[SIZE] = { 0 };
    
    scanf("%d", &T);
    
    while(T--){
        tot_candy = 0;
        candy = 0;
        
        scanf("%d", &n);
        
        for(i = 0; i < n; ++i){
            scanf("%d", &marks[i]);
        }
        
        // sort marks array
        quicksort(marks, 0, n);
        
        if(n >= 1){
            candy = 1;
        }
        
        tot_candy += candy;
        
        for(i = 1; i < n; ++i){
            if(marks[i] > marks[i - 1]){
                ++candy;
            }
            
            tot_candy += candy;
        }
        
        printf("%d\n", tot_candy);
    }
    
    return 0;
}

void quicksort(int array[], int lo, int hi){
    int j;
    
    if(lo < hi){
        j = partition(array, lo, hi);
        
        quicksort(array, lo, j);
        quicksort(array, j + 1, hi);
    }
}

int partition(int array[], int lo, int hi){
    int pivot = array[lo];
    int temp;
    
    int i = lo;
    int j = hi;
    
    while(i < j){
        do{
            ++i;
        }while(array[i] < pivot);
        
        do{
            --j;
        }while(array[j] > pivot);
        
        if(i < j){
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }    
    }
    
    array[lo] = array[j];
    array[j] = pivot;
    
    return j;
}