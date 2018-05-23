/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobshop;
import java.util.Scanner;
import org.jacop.core.*;
import org.jacop.constraints.*;
import org.jacop.search.*;
import model.ModelClass;
/**
 *
 * @author Асылбек
 * @version 1.0
 */
public class JobShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Store store = new Store();
           //System.out.println("Input r: ");
           Scanner sc = new Scanner(System.in);
           int n1, n2;
           
           IntVar[] r = new IntVar[9];
//           for(int i=0; i<3; i++){
//               System.out.println("Enter min num for r: ");
//               n1 = sc.nextInt();
//               System.out.println("Enter max num for r: ");
//               n2 = sc.nextInt();
//               r[i] = new IntVar(store, "r"+i, n1, n2);
//               System.out.println(r[i]);
//           }
            r[0] = new IntVar(store, "r"+0, 1, 3);
            r[1] = new IntVar(store, "r"+1, 1, 3);
            r[2] = new IntVar(store, "r"+2, 1, 3);
            r[3] = new IntVar(store, "r"+3, 1, 2);
            r[4] = new IntVar(store, "r"+4, 1, 3);
            r[5] = new IntVar(store, "r"+5, 1, 3);
            r[6] = new IntVar(store, "r"+6, 1, 3);
            r[7] = new IntVar(store, "r"+7, 2, 3);
            r[8] = new IntVar(store, "r"+8, 1, 3);
            

//           //alldifferent not need
//           IntVar[] v1 = {r[0], r[1], r[2]};
//           Constraint ctrR = new Alldifferent(v1);
//           store.impose(ctrR);
           
           IntVar[] d = new IntVar[8];
           for(int i=0; i<8; i++){
               d[i] = new IntVar(store, "d"+i, 1, 4);
           }
//           //alldiffrent not need
//           IntVar[] v2 = {d[0], d[1], d[2], d[3]};
//           Constraint ctrD=new Alldifferent(v2);
//           store.impose(ctrD);
           
           //element
           int el0[]={2, 4};
           int el1[]={0, 3, 2};
           int el2[]={0, 0, 2};
           int el3[]={2, 4};
           int el4[]={0, 3, 2};
           int el5[]={0, 0, 2};
           int el6[]={2, 4};
           int el7[]={0, 3, 2};
           int el8[]={0, 0, 2};
            Constraint ctr0 = new Element(r[0], el0, d[0]);
            store.impose(ctr0);
            Constraint ctr1 = new Element(r[1], el1, d[1]);
            store.impose(ctr1);
            Constraint ctr2 = new Element(r[2], el2, d[2]);
            store.impose(ctr2);
            Constraint ctr3 = new Element(r[3], el3, d[3]);
            store.impose(ctr3);
            Constraint ctr4 = new Element(r[4], el4, d[4]);
            store.impose(ctr4);
            Constraint ctr5 = new Element(r[5], el5, d[5]);
            store.impose(ctr5);
            Constraint ctr6 = new Element(r[6], el6, d[6]);
            store.impose(ctr6);
            Constraint ctr7 = new Element(r[7], el7, d[7]);
            store.impose(ctr7);
            Constraint ctr8 = new Element(r[8], el8, d[0]);
            store.impose(ctr8);
           
           
           IntVar cp = new IntVar(store, "cp", 1, 100);
           int cum[]={1,1,1,1};
//           //cumulative
//           Constraint ctrC = Cumulative(v1, 0, v2, cp);
//           store.impose(ctrC);
             Constraint ctrC0 = Cumulative(r[0], cum, d[0], cp);
             store.impose(ctrC0);
             Constraint ctrC1 = Cumulative(r[1], cum, d[1], cp);
             store.impose(ctrC1);
             Constraint ctrC2 = Cumulative(r[2], cum, d[2], cp);
             store.impose(ctrC2);
             Constraint ctrC3 = Cumulative(r[3], cum, d[3], cp);
             store.impose(ctrC3);
             Constraint ctrC4 = Cumulative(r[4], cum, d[4], cp);
             store.impose(ctrC4);
             Constraint ctrC5 = Cumulative(r[5], cum, d[5], cp);
             store.impose(ctrC5);
             Constraint ctrC6 = Cumulative(r[6], cum, d[6], cp);
             store.impose(ctrC6);
             Constraint ctrC7 = Cumulative(r[7], cum, d[7], cp);
             store.impose(ctrC7);
             Constraint ctrC8 = Cumulative(r[8], cum, d[0], cp);
             store.impose(ctrC8);
             
             

           //search
            Search<IntVar> search = new DepthFirstSearch<IntVar>();
            SelectChoicePoint<IntVar> select =
            new InputOrderSelect<IntVar>(store, v2,
            new IndomainMin<IntVar>());
            boolean result = search.labeling(store, select);
            
            //condition to print result
            if ( result )
            System.out.println("Right");
            else
            System.out.println("*** No");
            
           // this is how it is looks like
//need to use element            
//           store.impose element(r[0], [2, 4], d[0]),
//           store.impose element(r[1], [0, 3, 2], d[1]),
//           store.impose element(r[2], [0, 0, 0, 2], d[2]);
//           
//           cp::{1..100}
//           impose cumulative([r[0], r[1], r[2]], [1, 1, 1, 1], [d[0], d[1], d[2], d[3]], cp);
           
    }
    
}
