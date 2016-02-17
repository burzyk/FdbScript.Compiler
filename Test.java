import com.jpbnetsoftware.fdbscript.runtime.*;
import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeList;

class Test {



	public static void main(String[] args) {
		Example f = new Example();
		InvokeContext ctx = InvokeContext.createRootContext();
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
