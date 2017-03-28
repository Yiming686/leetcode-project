package Lintcode.BinaryTree.BST;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Lintcode.BinaryTree.TreeNode;

public class Distance_To_Root {

	@Test
	public void testLowestCommonAncestor4(){
		TreeNode root = TreeNode.fromStringToTree("{5,2,8,1,4,6,9,#,#,3,#,#,7,#,10,#,#,#,#,#,#}");
//		System.out.println(""+TreeNode.convertToString(root));
//		root == 5
		assertEquals(0, calculateDistToRoot(root,  root));
		TreeNode node = root.left.left;//1
		assertEquals(2, calculateDistToRoot(root,  node));
		node = root.right.right;//9
		assertEquals(2, calculateDistToRoot(root,  node));
		node = root.left.right.left;//3
		assertEquals(3, calculateDistToRoot(root,  node));
		node = root.right.left.right;//7
		assertEquals(3, calculateDistToRoot(root,  node));
		node = root.right;//8
		assertEquals(1, calculateDistToRoot(root,  node));
		assertEquals(-1, calculateDistToRoot( new TreeNode(33),   new TreeNode(39)));
//		assertTrue("",2==2);
//		assertFalse("This will succeed.", false);
//		assertArrayEquals(new int[0], new int[0]);
//		assertSame(expected, actual);


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.fromStringToTree("{5,2,8,1,4,6,9,#,#,3,#,#,7,#,10,#,#,#,#,#,#}");
		System.out.println("\n"+TreeNode.convertToString(root));
//		System.out.println(""+ calculateDistToRoot( root,  root));
//		System.out.println(""+ calculateDistToRoot( root,  null));
//		System.out.println(""+ calculateDistToRoot( null,  root.right.left));
//		System.out.println(""+ calculateDistToRoot( null, null));
//		System.out.println("5,8:: "+ calculateDistToRoot( root,  root.right));
//		System.out.println("5,6:: "+ calculateDistToRoot( root,  root.right.left));
//		System.out.println(""+ calculateDistToRoot( root,  new TreeNode(39)));
//		TreeNode node = root.right.left.right;//7
//		System.out.println(""+ calculateDistToRoot( root,  node));

		TreeNode node1 = root;//5
		TreeNode node2 = root.right.left.right;//7
		TreeNode lca = findLowestCommonAncestorBST(root, node1, node2);//5
		System.out.println(node1.val +", "+ node2.val + ", lca: "+lca.val);
		System.out.println("dis: "+(calculateDistToRoot( root, node1) + calculateDistToRoot( root, node2)-2*calculateDistToRoot( root, lca)));
		
		node1 = root.right.right.right;//10
		node2 = root.right.left.right;//7
		lca = findLowestCommonAncestorBST(root, node1, node2);//8
		System.out.println("lca: "+lca.val);
		System.out.println("dis: "+(calculateDistToRoot( root, node1) + calculateDistToRoot( root, node2)-2*calculateDistToRoot( root, lca)));

		node1 = root.right.right.right;//10
		node2 = root.left.left;//1
		lca = findLowestCommonAncestorBST(root, node1, node2);//5
		System.out.println("lca: "+lca.val);
		System.out.println("dis: "+(calculateDistToRoot( root, node1) + calculateDistToRoot( root, node2)-2*calculateDistToRoot( root, lca)));

		node1 = null;//null
		node2 = root.left.left;//1
		lca = findLowestCommonAncestorBST(root, node1, node2);//null, if null, means not found, dist = -1, directly
		System.out.println("lca: "+ (lca == null ? null : lca.val));
		System.out.println("dis: "+(lca == null ? -1 : calculateDistToRoot( root, node1) + calculateDistToRoot( root, node2)-2*calculateDistToRoot( root, lca)));

		node1 = new TreeNode(1);;//null
		node2 = root.left.left;//1
		lca = findLowestCommonAncestorBST(root, node1, node2);//null, if null, means not found, dist = -1, directly
		System.out.println("lca: "+ (lca == null ? null : lca.val));
		System.out.println("dis: "+(lca == null ? -1 : calculateDistToRoot( root, node1) + calculateDistToRoot( root, node2)-2*calculateDistToRoot( root, lca)));

		node1 = new TreeNode(1);;//null
		node2 = new TreeNode(1);//1
		lca = findLowestCommonAncestorBST(root, node1, node2);//null, if null, means not found, dist = -1, directly
		System.out.println("lca: "+ (lca == null ? null : lca.val));
		System.out.println("dis: "+(lca == null ? -1 : calculateDistToRoot( root, node1) + calculateDistToRoot( root, node2)-2*calculateDistToRoot( root, lca)));

		node1 = new TreeNode(1);;//null
		node2 = root.left.right;//1
		lca = findLowestCommonAncestorBST(root, node1, node2);//null, if null, means not found, dist = -1, directly
		System.out.println("lca: "+ (lca == null ? null : lca.val));
		System.out.println("dis: "+(lca == null ? -1 : calculateDistToRoot( root, node1) + calculateDistToRoot( root, node2)-2*calculateDistToRoot( root, lca)));

	}
	
//	BST, non-recursive solution
	static int calculateDistToRoot2(TreeNode root, TreeNode node){
		if(root == null || node == null){
			return -1;
		}
		int dist = 0;
		TreeNode temp = root;
		while(temp != null){
			if(temp == node){
				return dist;
			}else if(node.val < temp.val){
				temp = temp.left;
			}else{
				temp = temp.right;
			}
			dist++;
		}
		return -1;//not found
	}

	
//	recursvie solution
	static int calculateDistToRoot(TreeNode root, TreeNode node){
		return helper(root, node, 0);
	}
	static int helper(TreeNode root, TreeNode node ,int level){
		if(root == null || node == null){
			return -1;
		}
		if(node == root){
			return level;
		}else if(node.val < root.val){
			return helper(root.left, node, ++level);
		}else{
			return helper(root.right, node, ++level);
		}
	}

	//findLowestCommonAncestor
    //worked, it wors for BT and BST,  this one works if two nodes are not given in the tree
    public static TreeNode findLowestCommonAncestorBST(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null || node1 == null || node2 == null){
           return null;
        }        
        int[] count = new int[1];
//        以下两行，调用两种函数，都worked，
//        TreeNode node = findLowestCommonAncestor(root, node1, node2, count);
        TreeNode node = findLowestCommonAncestorBST(root, node1, node2, count);
//        System.out.println("count[0]: "+count[0]);
        if (count[0] == 2)
            return node;
        else
            return null;
    }


    //it only works for BST,  this one works even two nodes are not in the tree
    static TreeNode findLowestCommonAncestorBST(TreeNode root, TreeNode node1, TreeNode node2, int[] count){
        if(root == null || node1 == null || node2 == null){
            return null;
        }
        if(node1.val < root.val && node2.val < root.val){
        	return  findLowestCommonAncestorBST(root.left,  node1, node2, count);
        }else if(node1.val > root.val && node2.val > root.val){
        	return  findLowestCommonAncestorBST(root.right, node1, node2, count);
        }else{
        	TreeNode left =  findLowestCommonAncestorBST(root.left,  node1, node2, count);
        	TreeNode right = findLowestCommonAncestorBST(root.right, node1, node2, count);
        	System.out.println("root: "+root.val);
        	if(root == node1 || root == node2){
        		if(root == node1){
        			count[0]++;
        		} 
        		if(root == node2){
        			count[0]++;
        		}
        		System.out.println("count: "+count[0]);
        		return root;
        	} 
        	if(left!=null && right != null){
        		return root;
        	}
        	if(left != null){
        		return left;
        	}
        	if(right != null){
        		return right;
        	}
        	return null;
        }
    
    }
    
	//findLowestCommonAncestor
    //worked, it wors for BT and BST,  this one works if two nodes are not given in the tree
    public static TreeNode findLowestCommonAncestorBT(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null || node1 == null || node2 == null){
           return null;
        }        
        int[] count = new int[1];
//        以下两行，调用两种函数，都worked，
        TreeNode node = findLowestCommonAncestorBT(root, node1, node2, count);
//        TreeNode node = findLowestCommonAncestorBST(root, node1, node2, count);
//        System.out.println("count[0]: "+count[0]);
        if (count[0] == 2)
            return node;
        else
            return null;
    }

    //it only works for BT or BST,  this one works even two nodes are not in the tree
   static TreeNode findLowestCommonAncestorBT(TreeNode root, TreeNode node1, TreeNode node2, int[] count){
       if(root == null || node1 == null || node2 == null){
           return null;
       }
       TreeNode left =  findLowestCommonAncestorBT(root.left,  node1, node2, count);
       TreeNode right = findLowestCommonAncestorBT(root.right, node1, node2, count);
       if(root == node1 || root == node2){
    	   if(root == node1){
    		   count[0]++;
    	   } 
    	   if(root == node2){
    		   count[0]++;
    	   }
    	   return root;
       } 
    
        if(left!=null && right != null){
             return root;
        }
        if(left != null){
             return left;
        }
        if(right != null){
             return right;
        }
        return null;
   }

}
