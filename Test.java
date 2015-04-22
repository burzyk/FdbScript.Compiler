import com.jpbnetsoftware.fdbscript.runtime.*;

class Test {

	public Object ttt(Object []args) {
		String[] array = new String[2];

		return array;
	}

	public static void main(String[] args) {
		Fib f = new Fib();
		InvokeContext ctx = InvokeContext.createRootContext();

		ctx.defineValue("x", RuntimeList.create(new Object[] {1.0, 2.0, 3.0}));

		System.out.println(f.invoke(ctx));
		




		//Function_0 f0 = new Function_0();

		//System.out.println(f0.invoke(new InvokeContext(null)));

/*
		for( String s: f0.getArguments()){

			System.out.println(s);
		}

		System.out.println(f.invoke(new InvokeContext(null))); */
	}
}
