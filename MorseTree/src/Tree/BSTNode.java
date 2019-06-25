package Tree;

//builds node for binary tree
public class BSTNode<T>
{
	private BSTNode<T> left;
	private BSTNode<T> right;
	private T nodeData;

	BSTNode(T data, BSTNode<T> l, BSTNode<T> r)
	{
		left = l;
		right = r;
		nodeData = data;
	}

	BSTNode(T data)
	{
		left = null;
		right = null;
		nodeData = data;
	}
	  
	public BSTNode<T> getLeft()
	{
		return left;
	}
	
	public BSTNode<T> getRight()
	{
		return right;
	}
	  
	public void setLeft(BSTNode<T> node)
	{
		left = node;
	}
	  
	public void setRight(BSTNode<T> node)
	{
		right = node;
	}
	  
	public void setData(T item)
	{
		nodeData = item;
	}
	  
	public T getData()
	{
		return nodeData;
	}
}