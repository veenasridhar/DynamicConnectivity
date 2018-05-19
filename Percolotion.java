
public class Percolotion {
		int n;
		boolean opened[][];			//status of each grid
		int top;					//virtual top
		int bottom;					//virtual bottom
		public WeightedQuickUnion qf;
	public Percolotion(int n){
		this.n=n;
		opened=new boolean [n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				opened[i][j]=false;		//initially all grids are blocked
			}
		}
		top=n*n+1;
		bottom=n*n+2;
		qf= new WeightedQuickUnion(n*n+3);
	}
	public boolean IsPercolotes(){
		return qf.connected(top,bottom);	//percolates if top and bottom are connected
	}
	public void open (int x,int y){			//to open a grid
		opened[x][y]=true;
		if(x==0){
			qf.union(xy21D(x,y),top);
		}
		if(y==n-1){
			qf.union(xy21D(x,y),bottom);
		}
		if(x>0&&isOpen(x-1,y)){
			qf.union(xy21D(x,y),xy21D(x-1,y));
		}
		if(x<n-1&&isOpen(x+1,y)){
			qf.union(xy21D(x,y),xy21D(x+1,y));
		}
		if(y>0&&isOpen(x,y-1)){
			qf.union(xy21D(x,y),xy21D(x,y-1));
		}
		if(y<n-1&&isOpen(x,y+1)){
			qf.union(xy21D(x,y),xy21D(x,y+1));
		}
	}
	public boolean isOpen(int p,int q){
		return opened[p][q];
	}
	public int xy21D (int i,int j){		//converting the 2 dimensional to a 1 dimensional index.
		int id=((n*i)+j)+1;
		return id;
	}
}

