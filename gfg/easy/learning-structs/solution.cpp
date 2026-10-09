struct Node {
    // code here
    int data;
    Node* next;
    Node(){
        data=0;
        next=nullptr;
    }
    Node(int x){
        data=x;
        next=nullptr;
    }
};