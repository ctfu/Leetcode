/* Serialize: Pre-order traversal the tree and add dilimiter at the end of each node
 * Deserialize: Splite the serialized string and put it into queue for buiding tree */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializer(root, sb);
        return sb.toString();
    }
    /* pre-order traversal with sb */
    private void serializer(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append('X').append(':'); /* using 'X' to denote null, and ':' to seperate each node */
        }else{
            sb.append(root.val).append(':');
            serializer(root.left, sb);
            serializer(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(":")));/* Arrays.asList() can have array as input */
        return deserializer(queue);
    }
    private TreeNode deserializer(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("X")) return null; /* construct the end of the tree */
        /* pre-order construction of tree */
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializer(queue);
        node.right = deserializer(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
