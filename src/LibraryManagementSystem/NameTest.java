package LibraryManagementSystem;

public class NameTest 
{
private String name;

NameTest(String str)
{
	name=str;
}
public int countVowels()
{
	int x=0;
	char ch;
	name=name.toUpperCase();
	for(int i=0;i<name.length();i++)
	{
		ch=name.charAt(i);
		if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
		x++;
	}
	return x;
}
public boolean checkVowel()
{
 boolean x=false;
 char ch;
	name=name.toUpperCase();
	for(int i=0;i<name.length();i++)
	{
		ch=name.charAt(i);
		if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
		{
			x=true;
			break;
		}
	}
	return x;
}
public boolean checkLetters()
{
	boolean x=true;
	char ch;
	for(int i=0;i<name.length();i++)
	{
		ch=name.charAt(i);
		if(!Character.isLetter(ch))
		{
			x=false;
			break;
		}
		
	}
	return x;
}

}
