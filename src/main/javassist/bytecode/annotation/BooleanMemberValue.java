/*
 * JBoss, the OpenSource J2EE webOS
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package javassist.bytecode.annotation;

import javassist.bytecode.ConstPool;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Comment
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision: 1.2 $
 *
 **/
public class BooleanMemberValue extends MemberValue
{
   short const_value_index;

   public BooleanMemberValue(short cvi, ConstPool cp)
   {
      super('Z', cp);
      this.const_value_index = cvi;
   }

   public BooleanMemberValue(ConstPool cp)
   {
      super('Z', cp);
      setValue(false);
   }

   public boolean getValue()
   {
      return cp.getIntegerInfo(const_value_index) == 1;
   }

   public void setValue(boolean newVal)
   {
      const_value_index = (short)cp.addIntegerInfo(newVal ? 1 : 0);
   }

   public String toString()
   {
       return "" + getValue();
   }
   public void write(DataOutputStream dos) throws IOException
   {
      super.write(dos);
      dos.writeShort(const_value_index);
   }
   public void accept(MemberValueVisitor visitor)
   {
      visitor.visitBooleanMemberValue(this);
   }
}
