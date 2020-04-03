#include <stdio.h>
void UART0_Putstring(char* start){
	while(*start != NULL){
		printf("%c",*start);
		start++;
	}
}
int main(void) {
  char temp[] = {'s', 'a', 0};
  UART0_Putstring(temp);
  return 0;
}

//doesn't work:
#include "../out.c"
//does work:
#include "folderA/out.c"
//then just call functions as if you're in out.c
