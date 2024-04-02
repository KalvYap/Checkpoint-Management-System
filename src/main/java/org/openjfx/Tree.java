package org.openjfx;

class GFG
{

    // Class containing left and
    // right child of current
    // node and key value
    class Node
    {
        String key;
        Node left, right;

        public Node(String item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    GFG()
    {
        root = null;
    }

    // This method mainly
    // calls insertRec()
    void insert(String key)
    {
        root = insertRec(root, key);
    }

    /* A recursive function to
    insert a new key in BST */
    Node insertRec(Node root, String key)
    {

        /* If the tree is empty,
        return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        int compare =key.compareTo(root.key);

        /* Otherwise, recur
        down the tree */
        if (compare<0) {

            root.left = insertRec(root.left, key);

        } else if (compare>0)
            root.right = insertRec(root.right, key);

        /* return the root */
        return root;
    }

   int traverseInorder(Node n, String[] array, int index) {
       if (n != null) {
           index = traverseInorder(n.left, array, index);
           array[index++] = n.key;
           index = traverseInorder(n.right, array, index);
       }
       return index;
   }


    void treeins(String arr[], int size)
    {
        for(int i = 0; i < size+1; i++)
        {
            insert(arr[i]);

        }


    }
}