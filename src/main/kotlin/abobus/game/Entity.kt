package abobus.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*

class Entity(private val texture: Texture,
             private val body: Body) {

    fun render(spriteBatch: SpriteBatch) {
        spriteBatch.draw(
            texture,
            body.position.x - 2.80f, body.position.y - 2.80f,
            5.6F, 5.6F
        )
    }

    fun getPosition(): Vector2 = body.position

    fun applyForceToCenter(force: Vector2) {
        body.applyForceToCenter(force, true)
    }

    fun moveAt(enemies: ArrayList<Entity>) {
        val x = (MathUtils.random() * 100f) - MathUtils.random() * 100f
        val y = (MathUtils.random() * 100f) - MathUtils.random() * 100f
            enemies.forEach { body.applyForceToCenter(x, y, true) }
    }
}