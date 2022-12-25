//import java.util.Iterator;
//import My
//
//public class MyQueueIterator <T>  implements Iterator<T> {
//
//    public QueueIterator() {
//            listIndex = 0;
//            listIterator = q.get(listIndex).iterator();
//        }
//    @Override
//    public boolean hasNext() {
//        return q.get(listIndex).iterator();
//    }
//
//    @Override
//    public T next() {
//        return null;
//    }
//}

//    private class QueueIterator implements Iterator<T> {
//        private int listIndex;
//        private Iterator<T> listIterator;
//
//        public QueueIterator() {
//            listIndex = 0;
//            listIterator = q.get(listIndex).iterator();
//        }
//
//        @Override
//        public boolean hasNext() {
//            if (listIterator.hasNext()) {
//                return true;
//            }
//            for (int i = listIndex + 1; i < q.size(); i++) {
//                if (!q.get(i).isEmpty()) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        @Override
//        public T next() {
//            if (listIterator.hasNext()) {
//                return listIterator.next();
//            }
//            for (int i = listIndex + 1; i < q.size(); i++) {
//                if (!q.get(i).isEmpty()) {
//                    listIndex = i;
//
//                }
