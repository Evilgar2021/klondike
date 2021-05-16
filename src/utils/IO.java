     package utils;
     
     import java.io.BufferedReader;
     import java.io.PrintStream;
     
public class IO {
	private BufferedReader bufferedReader = new BufferedReader(
			new java.io.InputStreamReader(System.in));

	public String readString(String title) {
		String input = null;
		boolean ok = false;
		do {
			write(title);
			try {
				input = bufferedReader.readLine();
				ok = true;
			} catch (Exception ex) {
				writeError("de cadena de caracteres");
			}
		} while (!ok);
		return input;
	}

	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(readString(title));
				ok = true;
			} catch (Exception ex) {
				writeError("entero");
			}
		} while (!ok);
		return input;
	}

	public void write(String string) {
		System.out.print(string);
	}

	public void writeln(String string) {
		System.out.println(string);
	}

	private void writeError(String formato) {
		System.out.println("ERROR DE FORMATO! Introduzca un valor con formato "
				+ formato + ".");
	}
}