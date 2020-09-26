
/**
 * @author Jaspal chand Ramola
 */
public class LinkList {


    private class  Node
    {
       private int data;
       private Node next;

        private Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    Node HEAD=null;

    public void add(int data)
    {
        if(HEAD==null)
        {
            HEAD=new Node(data);
        }
        else
        {
            Node temp=HEAD;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=new Node(data);
        }

    }

    public void insert(int position,int data) throws Exception
    {
        Node temp=HEAD;
        if(position==1)
        {
            Node newNode=new Node(data);
            newNode.next=HEAD;
            HEAD=newNode;
        }
        else
        {
        for(int i=0;i<position-2;i++)
        {   
            if(temp.next!=null)
            {
            temp=temp.next;
            }
            else
            {
                throw new Exception("No Position in Link list");
            }
        }
        Node newNode=new Node(data);
        newNode.next=temp.next;
        temp.next=newNode;
    }
    }


    public void delete(int position) throws Exception
    {
        
        if(position==1)
        {
            HEAD=HEAD.next;
            return;
        }
        Node temp=HEAD;
        for(int i=0;i<position-2;i++)
        {   
            if(temp.next!=null)
            {
            temp=temp.next;
            }
            else
            {
                throw new Exception("No Position in Link list");
            }
        }
        temp.next=temp.next.next;
        
    }


    public String toString(){

        StringBuilder builder=new StringBuilder();
        builder.append(HEAD.data);
        Node temp=HEAD.next;
        while(temp!=null)
        {
            builder.append("-->"+temp.data);
            temp=temp.next;
        }

        return builder.toString();

    }    
    
}
