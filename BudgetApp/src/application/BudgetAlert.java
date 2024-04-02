package application;

public class BudgetAlert {
	private Category category;
	private double budgetLimit;
	
	public BudgetAlert(Category category, double budgetLimit) {
		this.category = category;
		this.budgetLimit = budgetLimit;
	}
	
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getBudgetLimit() {
        return budgetLimit;
    }

    public void setBudgetLimit(double budgetLimit) {
        this.budgetLimit = budgetLimit;
    }
	
}
