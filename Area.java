
public class Area {
	
	private Cell[][][] area = {new Cell[23][],new Cell[23][]};
	private int interation = 0;

	/* Участок кожи */
	public Area(){		
		for (int k=0;k<2;k++) {
			for (int i=1;i<22;i++){
				area[k][i] = new Cell[23];
				for (int j=1;j<22;j++){
					area[k][i][j] = new Cell(i,j);
				}
			}
			area[k][0] = new Cell[23];
			area[k][22] = new Cell[23];
			for (int i=0;i<23;i++){
				area[k][i][0] = new Cell_immuned(i,0);
				area[k][i][22] = new Cell_immuned(i,22);
				area[k][0][i] = new Cell_immuned(0,i);
				area[k][22][i] = new Cell_immuned(22,i);
			}
		}
		area[interation][11][11] = new Cell_infected(11, 11);
	}

	/* Iteration, not interaCtion */
	public void play(){
		for (int i=1;i<22;i++) {
			for (int j=1;j<22;j++){
				area[interation][i][j].cell_changes(this);
			}
		}
		
		area_output();
		interation = (interation+1)%2;
	} 
	
	/* Вывод участка */
	private void area_output(){
		for (int i=1;i<22;i++) {
			for (int j=1;j<22;j++) {
				area[interation][i][j].cell_output();
			}
			System.out.println();
		}
		System.out.println();
	}

	public int getTurn(){
		return interation;
	}

	public Cell[][] getField(int i){
		return area[i];
	}
}
