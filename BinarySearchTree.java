import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    public TreeNode root;

    BinarySearchTree(diccionario rootValue) {
        root = new TreeNode(rootValue);
    }

    BinarySearchTree() {
        root = null;
    }

    public boolean insert(diccionario value) {
        if (root == null) {
            root = new TreeNode(value);
            return true;
        } else {
            return insert(value, root);
        }
    }

//    ********************************* Breadth first search ***************************************

    public List<diccionario> BreadthFirstSearch() {
        return BreadthFirstSearch(root);
    }

    public List<diccionario> BreadthFirstSearch(TreeNode root) {
        ArrayList<diccionario> bfs_list = new ArrayList<diccionario>();
        ArrayList<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        while (q.size() > 0) {
            TreeNode currNode = q.remove(q.size() - 1);
            bfs_list.add(currNode.dic);
            if (currNode.left != null) {
                q.add(0, currNode.left);
            }
            if (currNode.right != null) {
                q.add(0, currNode.right);
            }
        }
        return bfs_list;
    }
    //    ******************************************************************************************

    //  ******************** Depth first search inorder,preorder,postorder **********************

    public List<diccionario> depthFirstSearch_InOrder() {
        ArrayList<diccionario> dps_lst = new ArrayList<diccionario>();
        return traverseInOrder(root, dps_lst);
    }

    public List<diccionario> traverseInOrder(TreeNode root, List<diccionario> dps_lst) {
        if (root.left != null) traverseInOrder(root.left, dps_lst);
        dps_lst.add(root.dic);
        if (root.right != null) traverseInOrder(root.right, dps_lst);
        return dps_lst;
    }

    public List<diccionario> depthFirstSearch_PreOrder() {
        ArrayList<diccionario> dps_lst = new ArrayList<diccionario>();
        return traversePreOrder(root, dps_lst);
    }

    public List<diccionario> traversePreOrder(TreeNode root, List<diccionario> dps_lst) {
        dps_lst.add(root.dic);
        if (root.left != null) traversePreOrder(root.left, dps_lst);
        if (root.right != null) traversePreOrder(root.right, dps_lst);
        return dps_lst;
    }

    public List<diccionario> depthFirstSearch_PostOrder() {
        ArrayList<diccionario> dps_lst = new ArrayList<diccionario>();
        return traversePostOrder(root, dps_lst);
    }

    public List<diccionario> traversePostOrder(TreeNode root, List<diccionario> dps_lst) {
        if (root.left != null) traversePostOrder(root.left, dps_lst);
        if (root.right != null) traversePostOrder(root.right, dps_lst);
        dps_lst.add(root.dic);
        return dps_lst;
    }

    //    ******************************************************************************************

    //    *************************** insert a node **********************************

    public boolean insert(diccionario value, TreeNode root) {
        if (root.dic.compareTo(value) == 0) return false;
        if (value.compareTo(root.dic) <0) {
            if (root.left != null) return insert(value, root.left);
            else {
                root.left = new TreeNode(value);
                return true;
            }
        } else {
            if (root.right != null) return insert(value, root.right);
            else {
                root.right = new TreeNode(value);
                return true;
            }
        }
    }

    //    ******************************************************************************************



    //    ******************* delete a node from tree **********************

    public List<TreeNode> findNodeAlsoItsParent(diccionario value) {
        TreeNode parent = null;
        return findNodeAndItsParent(parent, root, value);
    }

    public List<TreeNode> findNodeAndItsParent(TreeNode parent, TreeNode root, diccionario value) {
        ArrayList<TreeNode> lst = new ArrayList<TreeNode>();
        if (value.compareTo(root.dic) == 0) {
            lst.add(parent);
            lst.add(root);
            return lst;
        }
        if (value.compareTo(root.dic)<0) {
            if (root.left != null) {
                return findNodeAndItsParent(root, root.left, value);
            } else {
                return null;
            }
        } else {
            if (root.right != null) {
                return findNodeAndItsParent(root, root.right, value);
            } else {
                return null;
            }
        }
    }

    public void delete(diccionario value) {
        List<TreeNode> lst = findNodeAlsoItsParent(value);
        TreeNode nodeToBeDeleted = lst.get(1);
        TreeNode parentNode = lst.get(0);
        List<diccionario> nodes = new ArrayList<diccionario>();
        List<diccionario> effectedNodes = traversePreOrder(nodeToBeDeleted, nodes);
        effectedNodes.remove(effectedNodes.indexOf(value));

        if (parentNode == null) {
//            if the node to be deleted is root
            root = null;
        } else {
            if (parentNode.left.dic.compareTo(value)==0) parentNode.left = null;
            else parentNode.right = null;
        }
//        rearrange the binary tree from the effected nodes array
        for (diccionario i : effectedNodes) {
            this.insert(i);
        }
    }
    //    ******************************************************************************************


    //  ***************************** TreeNode ****************************************
    public static class TreeNode {
        public diccionario dic;
        public TreeNode left;
        public TreeNode right;

        TreeNode(diccionario dic) {
            this.dic = dic;
            this.left = this.right = null;
        }
    }
//    *********************************************************************************************
}
