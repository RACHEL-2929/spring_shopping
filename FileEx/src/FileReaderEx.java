import java.io.FileReader;

public class FileReaderEx {

	public static void main(String[] args) {

		FileReader fin = null;
		
		try {
			fin = new FileReader("c:\\windows\\system.ini");
			int c;
			while((c = fin.read())!=-1) {
				System.out.print((char)c);
			}
			fin.close();
		}catch (Exception e) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
	}

}
