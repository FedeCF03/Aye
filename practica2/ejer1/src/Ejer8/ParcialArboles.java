public class ParcialArboles {


    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)
{
    if (arbol1.isEmpty()) {
        return false;
    }
    return esPrefijo2(arbol1, arbol2);
}

    private boolean esPrefijo2(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)
        {
            if(arbol1.getData!=arbol2.getData)
            {
                return false;
            }
            boolean resultado=true;
            if (arbol1.hasLeftChild){
                if(arbol2.hasLeftChild){
                    res = res && esPrefijo2(arbol1.getLeftChild(), arbol2.getLeftChild());
                    else return false;
            } 

            if (arbol1.hasRightChild){
                if(arbol2.hasRightChild){
                    res = res && esPrefijo2(arbol1.getRightChild(), arbol2.getRightChild());
                    else return false;
            }

            return res;
        }
}}
