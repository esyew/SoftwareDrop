package milestone.functions;

import milestone.Product;

import java.util.Comparator;


//
//// Used in milestone 5
public class ProductNameComparator implements Comparator<Product> {


        // override the compare() method
        public int compare(Product s1, Product s2)
        {
            return s1.getItemName().compareTo(s2.getItemName());
        }

}
