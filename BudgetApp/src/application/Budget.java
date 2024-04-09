package application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import javafx.collections.ObservableList;

public class Budget {
	double totalBalance;
	ObservableList<BudgetItem> budgetItems;
	Set<Category> categories;

    public Budget(double totalBalance, ObservableList<BudgetItem> budgetItems, Set<Category> categories) {
        this.totalBalance = totalBalance;
        this.budgetItems = budgetItems;
        this.categories = categories;
    }
    
    public Set<Category> getCategories() {
    	return this.categories;
    }
    
    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public ObservableList<BudgetItem> getBudgetItems() {
    	return this.budgetItems;
    }
		
	public void addItem(BudgetItem item) {
		this.budgetItems.add(item);
	}
	
	public void deleteItem(BudgetItem item) {
		this.budgetItems.remove(item);
	}
	
	public void editItem(BudgetItem oldItem, BudgetItem newItem) {
        int index = budgetItems.indexOf(oldItem);
        if (index != -1) {
            budgetItems.set(index, newItem);
        } else {
            System.out.println("Item not found. Cannot edit.");
        }
    }
	
    public double calcBalance() {
        double totalAmount = 0;
        for (BudgetItem item : budgetItems) {
            totalAmount += item.getAmount();
        }
        return totalAmount;
    }
    
    public ArrayList<BudgetItem> filterByMonth(int month) {
        ArrayList<BudgetItem> filteredItems = new ArrayList<>();
        for (BudgetItem item : budgetItems) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(item.getDate());
            if (cal.get(Calendar.MONTH) + 1 == month) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
    
    public BudgetItem findMaxExpense() {
        Comparator<BudgetItem> comparator = Comparator.comparingDouble(BudgetItem::getAmount);

    	return Collections.max(budgetItems, comparator);
    }
    
    public BudgetItem findMinExpense() {
        Comparator<BudgetItem> comparator = Comparator.comparingDouble(BudgetItem::getAmount);

    	return Collections.min(budgetItems, comparator);
    }
	
}
