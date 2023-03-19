#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

#define SIZE_N 10000
#define SIZE_Q 1000000

int main(void) {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    
    int N, Q, i, j;
    int sum = 0;
    
    scanf("%d %d", &N, &Q);
    
    int n_array[SIZE_N] = { 0 };
    int q_array[SIZE_Q][2] = { 0 };
    
    
    for(i = 0; i < N; ++i){
        scanf("%d", &n_array[i]);
    }
    
    for(i = 0; i < Q; ++i){
        for(j = 0; j < 2; ++j){
            scanf("%d", &q_array[i][j]);
        }
    }
    
    for(i = 0; i < Q; ++i){
        sum = 0;
        for(j = q_array[i][0]; j <= q_array[i][1]; ++j){
            sum += n_array[j];
        }
        
        printf("%d\n", sum);
    }
    
    return 0;
}
