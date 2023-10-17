import acm.program.ConsoleProgram;

public class CallHierarchyEg extends ConsoleProgram {

        public void run() {
                method1();
        }

        void method1() {
                method2();
        }

        void method2() {
                method3();
        }

        void method3() {
                method4();
        }

        void method4() {
                int x = 0;
                println(10/x);
        }

}
