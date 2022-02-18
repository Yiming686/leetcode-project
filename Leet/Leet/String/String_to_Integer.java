package Leet.String;
/*

1. 扫描String: "4365" to 4365

result = 0;
while(i< len && Character.isDigit(str.charAt(i))){//就可以的得到digit
拿到digit后，整体提升result，给留出位置，然后加上digit，
//result = 10*result+digit;
result = 10*result+(str.charAt(i) - '0');
i++;
}
i--;//?? 如果是在以i为变量的for循环里面的话

2. 反转整数： 4365 to 5634

result = 0;//先拿到的是待求数字的最高位
while(n != 0){//就可以的得到digit
拿到digit后，整体提升result，给留出位置，然后加上digit，
result = 10*result+digit;
n的末尾删除；
}

循环变量有两个：result和（i或者n），前者是最终待求变量，后者是为了不断递进取得digit的变量

*/

public class String_to_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
