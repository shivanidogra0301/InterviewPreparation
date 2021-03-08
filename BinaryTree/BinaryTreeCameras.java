package BinaryTree;

public class BinaryTreeCameras {
    public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data, Node left, Node right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
    }
    int camera;
    public int minCameraCover(Node root) {
        camera = 0;
        if(minCamerahandler(root) == 1){
            camera++;
        }
        return camera;
    }
    // -1 = dont need camera
    // 0 = i am camera
    // 1 = need camera
    
    public int minCamerahandler(Node root){
        if(root == null){
            return -1;
        }
        int left = minCamerahandler(root.left);
        int right = minCamerahandler(root.right);
        if(left == 1 || right == 1){ // if any of my child needs camera ,i will be camera
            camera++;
            return 0;
        }
        if(left == 0 || right == 0){ // if any of my child is camera, so i dont need camera
            return -1;
        }
        
        
        
        return 1; // if neither of my child needs camera && neither of them is camera so I need the camera for myself so i will asked my parent
    }
}
