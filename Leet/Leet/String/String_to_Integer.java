package Leet.String;
/*

1. ɨ��String: "4365" to 4365

result = 0;
while(i< len && Character.isDigit(str.charAt(i))){//�Ϳ��Եĵõ�digit
�õ�digit����������result��������λ�ã�Ȼ�����digit��
//result = 10*result+digit;
result = 10*result+(str.charAt(i) - '0');
i++;
}
i--;//?? ���������iΪ������forѭ������Ļ�

2. ��ת������ 4365 to 5634

result = 0;//���õ����Ǵ������ֵ����λ
while(n != 0){//�Ϳ��Եĵõ�digit
�õ�digit����������result��������λ�ã�Ȼ�����digit��
result = 10*result+digit;
n��ĩβɾ����
}

ѭ��������������result�ͣ�i����n����ǰ�������մ��������������Ϊ�˲��ϵݽ�ȡ��digit�ı���

*/

public class String_to_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
