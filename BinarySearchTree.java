public class BinarySearchTree
{
	private TreeNode node;
    BinarySearchTree()
    {
    	 node = null;
    }
    public void setNode(TreeNode newNode)
		{
			node = newNode;
		}
		public TreeNode getNode()
		{
			return node;
	}
    public void insertNode(int Nkey)
    {
    	node = insertInTree(node, Nkey);
    }
    public TreeNode insertInTree(TreeNode node, int keyNode)
    {

        if (node == null)
        {
            node = new TreeNode(keyNode);
            return node;
        }
        if (keyNode < node.item)
            node.left = insertInTree(node.left, keyNode);
        else if (keyNode > node.item)
            node.right = insertInTree(node.right, keyNode);

        return node;
    }
    public void inorder()
    {
    	inorderTree(node);
    }
    public void inorderTree(TreeNode node)
    {
        if (node != null)
        {
        	inorderTree(node.left);
        	System.out.print(node.item+ " ");
            inorderTree(node.right);
        }
    }
    public void postorder()
	{
	    postorderTree(node);
    }
    public void postorderTree(TreeNode node)
    {
	   if (node != null)
	   {
	       postorderTree(node.left);
	       postorderTree(node.right);
	       System.out.print(node.item+ " ");
	   }
    }
    public void preorder()
	{
		   preorderTree(node);
    }
    public void preorderTree(TreeNode node)
	{
	   if (node != null)
	    {
			System.out.print(node.item+ " ");
	        preorderTree(node.left);
	        preorderTree(node.right);
	    }
    }
    public void swapSubTree()
    {
       swapSubtrees(node);
    }
    public TreeNode swapSubtrees(TreeNode tnode)
    {

        if (tnode == null)
            return tnode;

        TreeNode left = swapSubtrees(tnode.left);
        TreeNode right = swapSubtrees(tnode.right);

        tnode.left = right;
        tnode.right = left;

        return tnode;
    }
   public int singleParent(TreeNode node,int count)
   {
        if((node==null) || ((node.left==null)&&(node.right==null)))
            return count;
        count = singleParent(node.left, count);
        if(node.left==null||node.right==null)
            count ++;
        count = singleParent(node.right, count);
        return count;
    }
    public int singleParent()
    {
        return singleParent(node, 0);
    }
    public static void main(String[] args)
    {

        BinarySearchTree tree1 = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();


        tree1.insertNode(1);
        tree1.insertNode(2);
        tree1.insertNode(4);
        tree1.insertNode(5);
        tree1.insertNode(3);
        tree1.insertNode(6);

       System.out.println("Tree1");
       System.out.println("inorder:");
       tree1.inorder();
       System.out.println("\npreorder:");
       tree1.preorder();
       System.out.println("\npostorder:");
       tree1.postorder();
       System.out.println("\nSingle Parent in Tree1 --> "+  tree1.singleParent());

        tree2.insertNode(14);
        tree2.insertNode(4);
        tree2.insertNode(3);
        tree2.insertNode(9);
        tree2.insertNode(7);
        tree2.insertNode(5);
        tree2.insertNode(15);
        tree2.insertNode(18);
        tree2.insertNode(16);
        tree2.insertNode(17);
        tree2.insertNode(20);

        System.out.println("\nTree2");
        System.out.println("inorder:");
        tree2.inorder();
        System.out.println("\npreorder:");
        tree2.preorder();
        System.out.println("\npostorder:");
        tree2.postorder();
        System.out.println("\n\nSingle Parent in Tree2 --> "+tree2.singleParent());
    }
}
