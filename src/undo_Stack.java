
public class undo_Stack{
	private static int[] num_array = new int[16];
	private static int[] row_array = new int[16];
	private static int[] column_array = new int[16];
	private static int num_of_elements = 0;
	
	public void push(int number, int row, int column)
	{
		for(int i=num_of_elements ; i >= 0  ; i--)
		{
			num_array[i+1] = num_array[i];
			row_array[i+1] = row_array[i];
			column_array[i+1] = column_array[i];
			
		}
		num_array[0] = number;
		row_array[0] = row;
		column_array[0] = column;
		num_of_elements++;
	}
	public int elements()
	{
		return num_of_elements;
	}
	public int[] top()
	{
		int[] arr = new int[3];
		arr[0] = num_array[0];
		arr[1] = row_array[0];
		arr[2] = column_array[0];
		return arr ;
	}
	public void reset()
	{
		num_of_elements = 0;
		num_array = new int[16];
		row_array = new int[16];
		column_array = new int[16];
	}
	public void pop()
	{
		for(int i=1; i< num_of_elements  ; i++)
		{
			num_array[i-1] = num_array[i];
			row_array[i-1] = row_array[i];
			column_array[i-1] = column_array[i];
		}
		/*num_array[num_of_elements] = 0;
		row_array[num_of_elements] = row;
		column_array[num_of_elements] = column;*/
		num_of_elements--;
	}
	public void display()
	{
		System.out.println("Number of elements are: " + num_of_elements);
		for(int i=0; i < num_of_elements; i++)
		{
			System.out.println("Number: " + num_array[i] + "\tRow: " + row_array[i] + "\tColumn: " + column_array[i]);
		}
	}
	
}
