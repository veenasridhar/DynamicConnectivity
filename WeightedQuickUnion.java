
public class WeightedQuickUnion {
	int n,count;					// size of the array
	int array[],size[];		
	
	public WeightedQuickUnion(int n){
		this.n=n;	//initializing the size of the array
		count=n;
		array=new int[n];	
		size=new int[n];
		for(int i=0;i<n;i++){
			array[i]=i;		//initializing the array elements
			size[i]=1;		//intialzing the size to be 1
		}
	}
	public void union(int p,int q){
		int rootOfp=root(p);	//finding the root of the given element
		int rootOfq=root(q);	
		if(size[rootOfp]<size[rootOfq]){ //adding the smaller tree to the larger tree
			array[rootOfp]=rootOfq;
			size[rootOfq]+=size[rootOfp];	//updating the size
		}
		else{
			array[rootOfq]=rootOfp;
			size[rootOfp]+=size[rootOfq];
		}
		count--;						//reducing the number of induvidual components
	}
	public int count (){
		return count;
	}
	public boolean connected(int p,int q){
		return (root(p)==root(q));			//checking the connectivity
	}
	public int root (int id){
		while(array[id]!=id){
			id=array[id];					//finding the root unit the element is equal to itself
		}
		return id;
	}
	public static void main(String args[]){
		/*WeightedQuickUnion obj=new WeightedQuickUnion(10);
		obj.union(1,6);
		obj.union(2,1);
		obj.union(4, 1);
		obj.union(9, 8);
		obj.union(7, 8);
		obj.union(7, 4);
		System.out.println(obj.connected(2,6));
		System.out.println(obj.connected(4,2));
		System.out.println(obj.connected(9,2));
		for(int i=0;i<obj.n;i++)
		System.out.println(obj.array[i]);*/
		Percolotion p_obj=new Percolotion(4);
		p_obj.open(0,0);
		p_obj.open(0, 2);
		p_obj.open(0,3);
		p_obj.open(1, 1);
		p_obj.open(1,2);
		p_obj.open(2, 0);
		p_obj.open(2, 1);
		p_obj.open(2, 3);
		p_obj.open(3, 0);
		p_obj.open(3, 2);
		System.out.println(p_obj.IsPercolotes());
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.println(p_obj.opened[i][j]);
			}
		}
		}
}
