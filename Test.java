

class Test {

	public Object ttt(Object []args) {
		Double x = Double.valueOf(3);
		Double y = Double.valueOf(4);
		Double z = y + x;

		return (z == 1) ? x : (z == 7) ? y : 8;
	}

	public static void main(String[] args) {
		Fib f = new Fib();
		System.out.println(f.invoke(null));
	}
}
