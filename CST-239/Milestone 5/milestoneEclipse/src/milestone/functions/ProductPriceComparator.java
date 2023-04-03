package milestone.functions;

import milestone.Product;

import java.util.Comparator;
// Used in milestone 5

public class ProductPriceComparator implements Comparator<Product> {

    /**
     * @param s1 the first object to be compared.
     * @param s2 the second object to be compared.
     * @return int comparison result
     */
    public int compare(Product s1, Product s2)
    {
        if (s1.getItemPrice() == s2.getItemPrice())
            return 0;
        else if (s1.getItemPrice() > s2.getItemPrice())
            return 1;
        else
            return -1;
    }
}


