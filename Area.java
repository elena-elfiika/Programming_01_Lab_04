
public class Area {
	
	private Cell[][] area_1 = new Cell[23][23];
	private Cell[][] area_2 = new Cell[23][23];
	private int interation = 0;

	//Участок кожи. Заполнение клетками
	public Area(){	
			for (int i=1;i<22;i++){
				for (int j=1;j<22;j++){
					area_1[i][j] = new Cell(i,j);
				}
			}
			
			for (int i=0;i<23;i++){
				area_1[i][0] = new Cell_immuned(i,0);
				area_1[i][22] = new Cell_immuned(i,22);
				area_1[0][i] = new Cell_immuned(0,i);
				area_1[22][i] = new Cell_immuned(22,i);
			}
		area_1[11][11] = new Cell_infected(11, 11);
		area_2 = area_1;
	}

	//Iteration, not interaCtion
	public void play(){
		
		area_output();
		
		if (interation == 0){
			for (int i=1;i<22;i++){
				for (int j=1;j<22;j++){
					area_1[i][j].cell_changes(this);
				}
			}
		}
		
		if (interation == 1){
			for (int i=1;i<22;i++){
				for (int j=1;j<22;j++){
					area_2[i][j].cell_changes(this);
				}
			}
		}

		interation = (interation+1)%2;
	} 
	
	//Area output
	private void area_output(){
		if(interation == 0){
			for (int i=1;i<22;i++) {
				for (int j=1;j<22;j++) {
					area_1[i][j].cell_output();
				}
				System.out.println();
			}
			System.out.println();
		}

		if(interation == 1){
			for (int i=1;i<22;i++) {
				for (int j=1;j<22;j++) {
					area_2[i][j].cell_output();
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public int getTurn(){
		return interation;
	}

	public Cell[][] getField(int i){
		if (i == 0) {
			return area_1;
		} else {
			return area_2;
		}
	}
}
