import java.util.ArrayList;
import java.util.List;

/**
 * Algoritmos y Estructura de Datos
 * Universidad del Valle de Guatemala
 * Hoja de Trabajo No.7
 * File: BinarySearchTree
 * @author Sebastián Franco - 21484
 * @author Juan Miguel Gonzalez-Campo - 21077
 * @version 1.1
 * @since 28/03/2021
 */

public class BinarySearchTree { 
    public TreeNode root;

    /**
     * Constructor de la clase
     * @param rootValue
     */
    BinarySearchTree(diccionario rootValue) { 
        root = new TreeNode(rootValue);
    }

    BinarySearchTree() { ///Se crea 
        root = null;
    }

    /**
     * @param value
     * @return boolean
     */
    public boolean insert(diccionario value) {  ///Se inserta en el diccionario
        if (root == null) {
            root = new TreeNode(value);
            return true;
        } else {
            return insert(value, root);
        }
    }

//    ********************************* Breadth first search ***************************************

    /**
     * @return BreadthFirstSearch
     */
    public List<diccionario> BreadthFirstSearch() { 
        return BreadthFirstSearch(root);
    }

    /**
     * @param root
     * @return diccionario 
     */
    public List<diccionario> BreadthFirstSearch(TreeNode root) { ///Se crea el Arbol binario
        ArrayList<diccionario> bfs_list = new ArrayList<diccionario>();
        ArrayList<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        while (q.size() > 0) {
            TreeNode currNode = q.remove(q.size() - 1);
            bfs_list.add(currNode.dic);
            if (currNode.left != null) { ///Se aniade la rama izquierda
                q.add(0, currNode.left);
            }
            if (currNode.right != null) { ///Se aniade la rama derecha
                q.add(0, currNode.right);
            }
        }
        return bfs_list;
    }
    //    ******************************************************************************************

    //  ******************** Depth first search inorder,preorder,postorder **********************

    /**
     * @return InOrder
     */
    public List<diccionario> depthFirstSearch_InOrder() { ///Buscar en odrden
        ArrayList<diccionario> dps_lst = new ArrayList<diccionario>();
        return traverseInOrder(root, dps_lst);
    }

    /**
     * @param root
     * @param dps_lst
     * @return dps_list
     */
    public List<diccionario> traverseInOrder(TreeNode root, List<diccionario> dps_lst) { 
        if (root.left != null) traverseInOrder(root.left, dps_lst);
            dps_lst.add(root.dic);
        if (root.right != null) traverseInOrder(root.right, dps_lst);
            return dps_lst;
    }

    /**
     * @return transversePreOrder
     */
    public List<diccionario> depthFirstSearch_PreOrder() { 
        ArrayList<diccionario> dps_lst = new ArrayList<diccionario>();
        return traversePreOrder(root, dps_lst);
    }

    /**
     * @param root
     * @param dps_lst
     * @return dps_list
     */
    public List<diccionario> traversePreOrder(TreeNode root, List<diccionario> dps_lst) {
        dps_lst.add(root.dic);
        if (root.left != null) traversePreOrder(root.left, dps_lst);
        if (root.right != null) traversePreOrder(root.right, dps_lst);
        return dps_lst;
    }

    public List<diccionario> depthFirstSearch_PostOrder() { ///Busca el primer elemento
        ArrayList<diccionario> dps_lst = new ArrayList<diccionario>();
        return traversePostOrder(root, dps_lst);
    }

    /**
     * @param root
     * @param dps_lst
     * @return
     */
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

    /**
     * @param value
     * @return Parent Node
     */
    public List<TreeNode> findNodeAlsoItsParent(diccionario value) {
        TreeNode parent = null;
        return findNodeAndItsParent(parent, root, value);
    }

    /**
     * @param parent
     * @param root
     * @param value
     * @return list
     */
    public List<TreeNode> findNodeAndItsParent(TreeNode parent, TreeNode root, diccionario value) { //Encuentra la Raiz
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

    /**
     * @param value
     */
    public void delete(diccionario value) { //Elimina del diccionario
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

    public static class TreeNode { ///Treenode.
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
