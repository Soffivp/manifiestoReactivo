import rx._

implicit val ctx: Ctx.Owner = Ctx.Owner.safe()

val a = Var(1)
val b = Var(2)
val c = Rx{a() + b()}
val d = Rx{c() * 5}
val e = Rx{c() + 4}
val f = Rx{d() + e()+ 4}

println(f.now)

a() = 3

println(f.now)
