package Tree;

//defines methods for traversing, inserting, finding, and retrieving values in tree
public class BinaryTree<Element>
{
	private BSTNode<Element> current;
	private BSTNode<Element> root;

	private void findParent(BSTNode<Element> finder)
	{
		if (finder == null)
		{
			return;
		}
		if (current == root)
		{
			return;
		}
		if (finder.getLeft() == current)
		{
			current = finder;
		}
		else if (finder.getRight() == current)
		{
			current = finder;
		}
		else
		{
			findParent(finder.getRight());
			findParent(finder.getLeft());
		}
	}

	//inserts new element in correct location
	public void insert(Element item, Relative where)
	{
		BSTNode<Element> newNode = new BSTNode<Element>(item);
		
		if(where == Relative.ROOT)
		{
			root = newNode;
			current = newNode;
		}
		else if(where == Relative.LEFT)
		{
			current.setLeft(newNode);
			current = newNode;
		}
		else if(where == Relative.RIGHT)
		{
			current.setRight(newNode);
			current = newNode;
		}
	}

	//checks if tree is empty
	public boolean isEmpty()
	{
		if(root == null)
		{
			return true;
		}
		return false;
	}

	
	public Boolean move(Relative where)
	{
		switch(where)
		{
			case PARENT:
				if(current == root)
				{
					return false;
				}
				findParent(root);
				return true;
			case LEFT:
				if(current.getLeft() == null)
				{
					return false;
				}
				current = current.getLeft();
				return true;
			case RIGHT:
				if(current.getRight() == null)
				{
					return false;
				}
				current = current.getRight();
				return true;
			case ROOT:
				current = root;
				return true;
			default:
				return false;
		}
	}
  
	public Element retrieve()
	{
		return current.getData();
	}
  
	public String traverse()
	{
		return traverseTree(root);
	}

	private String traverseTree(BSTNode<Element> target)
	{
		if(target == null)
		{
			return "";
		}
		return target.getData().toString() + traverseTree(target.getLeft()) +
				traverseTree(target.getRight());
	}
}