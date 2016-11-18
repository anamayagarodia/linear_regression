import java.util.*;
class Regression
{
  private double x[];
  private double y[];
  private double xbar;
  private double ybar;
  private int num_Dat;
  private double sigma_x;
  private double sigma_y;
  private double correlation;
  private double covariance;
  private double theta_1;
  private double theta_0;
  private double input_Data;
  private double predicted_Output;
  public Regression(int num)
  {
    num_Dat = num;
    x = new double[num_Dat];
    y = new double[num_Dat];
    xbar = 0;
    ybar = 0;
    sigma_x=0;
    sigma_y=0;
    correlation=0;
    covariance=0;
    theta_1=0;
    theta_0=0;
    input_Data=0;
    predicted_Output=0;
    input();
    covariance();
    correlation();
    slope_Of_Regression();
    intercept_Of_Regression();
  }
  private double mean(double a[])
  {
    double total = 0;
    for(int i = 0; i < a.length; i++)
      total+=a[i];
    return (total/ (a.length));
  }
  private double standard_Deviation(double a[], double mean)
  {
    double total = 0;
    for(int i = 0; i < a.length; i++)
      total+=(Math.pow(((a[i]-mean)),2));
    return (Math.sqrt ((total/a.length)));
  }
  private void covariance()
  {
    xbar = mean(x);
    ybar = mean(y);
    double total = 0;
    for(int i = 0; i < x.length; i++)
      total+=((x[i]-xbar) * (y[i]-ybar));
    covariance = ((total/x.length));
  }
  private void correlation()
  {
    sigma_x = standard_Deviation(x,xbar);
    sigma_y = standard_Deviation(y,ybar);
    correlation = (covariance/(sigma_x*sigma_y));
  }
  private void slope_Of_Regression()
  {
    theta_1 = (correlation * (sigma_y / sigma_x));
  }
  private void intercept_Of_Regression()
  {
    theta_0 = ybar - (theta_1*xbar);
  }
  public double h(double x)
  {
    return (theta_1*x + theta_0);
  }
  private void input()
  {
    Scanner in = new Scanner(System.in);
    for(int i=0; i<num_Dat; i++)
    {
      System.out.println("Enter x: ");
      x[i]=in.nextDouble();
      System.out.println("");
      System.out.println("Enter y: ");
      y[i]=in.nextDouble();
      System.out.println("");
    }
  }
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter number of points:");
    int num_of_data = in.nextInt();
    System.out.println("");
    Regression ob = new Regression(num_of_data);
    System.out.println("");
    System.out.println("Enter x: ");
    ob.input_Data = in.nextDouble();
    ob.predicted_Output = ob.h(ob.input_Data);
    System.out.println(ob.predicted_Output);
  }
}
